package com.leimans.sensitivewordlib.toolgood.core.internals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieNode implements Comparable<TrieNode> {

    public int Index;
    public int Layer;
    public boolean End;
    public char Char;
    public List<Integer> Results;
    public HashMap<Character, TrieNode> m_values;// 以TrieNode的内容为key,记录一系列的子TrieNode
    public TrieNode Failure;
    public TrieNode Parent;
    public boolean IsWildcard;
    public int WildcardLayer;
    public boolean HasWildcard;


    public TrieNode() {
        m_values = new HashMap<Character, TrieNode>();
        Results = new ArrayList<Integer>();
    }

    /**
     * 构建一个新的TrieNode,且构建缓存中
     * @param c
     * @return
     */
    public TrieNode createNextNew(final Character c) {
        if (m_values.containsKey(c)) {
            return m_values.get(c);
        }
        final TrieNode node = new TrieNode();
        node.Parent = this;
        node.Char = c;
        m_values.put(c, node);
        return node;
    }

    public void SetResults(final Integer index) {
        if (End == false) {
            End = true;
        }
        if (Results.contains(index) == false) {
            Results.add(index);
        }
    }

    @Override
    public int compareTo(final TrieNode o) {
        return this.Layer - o.Layer  ;
    }
}
