package com.leimans.sensitivewordlib.core;

import com.leimans.sensitivewordlib.core.internals.BaseSearchEx;

import java.util.ArrayList;
import java.util.List;


public class StringSearchEx extends BaseSearchEx {
    /**
     * 在文本中查找所有的关键字
     * 
     * @param text 文本
     * @return
     */
    public List<String> FindAll(final String text) {
        final List<String> result = new ArrayList<String>();

        int p = 0;
        for (int i = 0; i < text.length(); i++) {
            final char t1 = text.charAt(i);
            final Integer t = _dict[t1];
            if (t == 0) {
                p = 0;
                continue;
            }
            int next;
            if (p == 0 || t < _min[p] || t > _max[p]) {
                next = _first[t];
            } else {
                final int index = _nextIndex[p].IndexOf(t);
                if (index == -1) {
                    next = _first[t];
                } else {
                    next = _nextIndex[p].GetValue(index);
                }
            }
            if (next != 0) {
                for (int j = _end[next]; j < _end[next + 1]; j++) {
                    result.add(_keywords[_resultIndex[j]]);
                }
            }
            p = next;
        }
        return result;
    }

    /**
     * 在文本中查找第一个关键字
     * 
     * @param text 文本
     * @return
     */
    public String FindFirst(final String text) {
        int p = 0;
        for (int i = 0; i < text.length(); i++) {
            final char t1 = text.charAt(i);
            final int t = _dict[t1];
            if (t == 0) {
                p = 0;
                continue;
            }
            int next;
            if (p == 0 || t < _min[p] || t > _max[p]) {
                next = _first[t];
            } else {
                final int index = _nextIndex[p].IndexOf(t);
                if (index == -1) {
                    next = _first[t];
                } else {
                    next = _nextIndex[p].GetValue(index);
                }
            }
            if (next != 0) {
                final int start = _end[next];
                if (start < _end[next + 1]) {
                    return _keywords[_resultIndex[start]];
                }
            }
            p = next;
        }
        return null;
    }

    /**
     * 判断文本是否包含关键字
     * 
     * @param text 文本
     * @return
     */
    public boolean ContainsAny(final String text) {
        int p = 0;
        for (int i = 0; i < text.length(); i++) {
            final char t1 = text.charAt(i);
            final int t = _dict[t1];
            if (t == 0) {
                p = 0;
                continue;
            }
            int next;
            if (p == 0 || t < _min[p] || t > _max[p]) {
                next = _first[t];
            } else {
                final int index = _nextIndex[p].IndexOf(t);
                if (index == -1) {
                    next = _first[t];
                } else {
                    next = _nextIndex[p].GetValue(index);
                }
            }

            if (next != 0) {
                if (_end[next] < _end[next + 1]) {
                    return true;
                }
            }
            p = next;
        }
        return false;
    }

    /**
     * 在文本中替换所有的关键字, 替换符默认为 *
     * 
     * @param text 文本
     * @return
     */
    public String Replace(final String text) {
        return Replace(text, '*');
    }

    /**
     * 在文本中替换所有的关键字
     * 
     * @param text        文本
     * @param replaceChar 替换符
     * @return
     */
    public String Replace(final String text, final char replaceChar) {
        final StringBuilder result = new StringBuilder(text);
        int p = 0;
        for (int i = 0; i < text.length(); i++) {
            final char t1 = text.charAt(i);
            final int t = _dict[t1];
            if (t == 0) {
                p = 0;
                continue;
            }
            int next;
            if (p == 0 || t < _min[p] || t > _max[p]) {
                next = _first[t];
            } else {
                final int index = _nextIndex[p].IndexOf(t);
                if (index == -1) {
                    next = _first[t];
                } else {
                    next = _nextIndex[p].GetValue(index);
                }
            }
            if (next != 0) {
                final int start = _end[next];
                if (start < _end[next + 1]) {
                    final int maxLength = _keywords[_resultIndex[start]].length();
                    for (int j = i + 1 - maxLength; j <= i; j++) {
                        result.setCharAt(j, replaceChar);
                    }

                }
            }
            p = next;
        }
        return result.toString();
    }

}