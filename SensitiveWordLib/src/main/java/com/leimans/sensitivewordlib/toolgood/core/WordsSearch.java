package com.leimans.sensitivewordlib.toolgood.core;

import com.leimans.sensitivewordlib.toolgood.core.internals.BaseSearch;
import com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2;

import java.util.ArrayList;
import java.util.List;


public class WordsSearch extends BaseSearch {
    public String[] _others;

    /**
     * 在文本中查找第一个关键字
     * 
     * @param text 文本
     * @return
     */
    public com.leimans.sensitivewordlib.toolgood.core.WordsSearchResult FindFirst(final String text) {
        com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 ptr = null;
        for (int i = 0; i < text.length(); i++) {
            final char t = text.charAt(i);
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 tn = null;
            if (ptr == null) {
                tn = _first[t];
            } else {
                if (ptr.HasKey(t) == false) {
                    tn = _first[t];
                } else {
                    tn = ptr.GetValue(t);
                }
            }
            if (tn != null) {
                if (tn.End) {
                    for (final Integer index : tn.Results) {
                        final String key = _keywords[index];
                        return new com.leimans.sensitivewordlib.toolgood.core.WordsSearchResult(key, i + 1 - key.length(), i, index);
                    }
                }
            }
            ptr = tn;
        }
        return null;
    }

    /**
     * 在文本中查找所有的关键字
     * 
     * @param text 文本
     * @return
     */
    public List<com.leimans.sensitivewordlib.toolgood.core.WordsSearchResult> FindAll(final String text) {
        com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 ptr = null;
        final List<com.leimans.sensitivewordlib.toolgood.core.WordsSearchResult> list = new ArrayList<com.leimans.sensitivewordlib.toolgood.core.WordsSearchResult>();

        for (int i = 0; i < text.length(); i++) {
            final char t = text.charAt(i);
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 tn = null;
            if (ptr == null) {
                tn = _first[t];
            } else {
                if (ptr.HasKey(t) == false) {
                    tn = _first[t];
                } else {
                    tn = ptr.GetValue(t);
                }
            }
            if (tn != null) {
                if (tn.End) {
                    for (final Integer index : tn.Results) {
                        final String key = _keywords[index];
                        final com.leimans.sensitivewordlib.toolgood.core.WordsSearchResult item = new WordsSearchResult(key, i + 1 - key.length(), i, index);
                        list.add(item);
                    }
                }
            }
            ptr = tn;
        }
        return list;
    }

    /**
     * 判断文本是否包含关键字
     * 
     * @param text 文本
     * @return
     */
    public boolean ContainsAny(final String text) {
        com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 ptr = null;
        for (int i = 0; i < text.length(); i++) {
            final char t = text.charAt(i);
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 tn = null;
            if (ptr == null) {
                tn = _first[t];
            } else {
                if (ptr.HasKey(t) == false) {
                    tn = _first[t];
                } else {
                    tn = ptr.GetValue(t);
                }
            }
            if (tn != null) {
                if (tn.End) {
                    return true;
                }
            }
            ptr = tn;
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

        com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode2 ptr = null;
        for (int i = 0; i < text.length(); i++) {
            final char t = text.charAt(i);
            TrieNode2 tn = null;
            if (ptr == null) {
                tn = _first[t];
            } else {
                if (ptr.HasKey(t) == false) {
                    tn = _first[t];
                } else {
                    tn = ptr.GetValue(t);
                }
            }
            if (tn != null) {
                if (tn.End) {
                    final int maxLength = _keywords[tn.Results.get(0)].length();
                    final int start = i + 1 - maxLength;
                    for (int j = start; j <= i; j++) {
                        result.setCharAt(j, replaceChar);
                    }
                }
            }
            ptr = tn;
        }
        return result.toString();
    }

}