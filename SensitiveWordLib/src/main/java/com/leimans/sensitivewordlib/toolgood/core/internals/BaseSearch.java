package com.leimans.sensitivewordlib.toolgood.core.internals;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class BaseSearch {
    protected TrieNode2[] _first = new TrieNode2[Character.MAX_VALUE + 1];
    protected String[] _keywords;


    /**
     * 设置关键字
     * 
     * @param keywords 关键字列表
     */
    public void SetKeywords(List<String> keywords) {
        _keywords = new String[keywords.size()];
        _keywords = keywords.toArray(_keywords);
        keywords.clear();
        keywords=null;
        SetKeywords();
    }

    protected void SetKeywords() {
        com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode root = new com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode();
        Map<Integer, List<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode>> allNodeLayers = new Hashtable<Integer, List<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode>>();
        for (int i = 0; i < _keywords.length; i++) {
            String p = _keywords[i];
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode nd = root;
            for (int j = 0; j < p.length(); j++) {
                char c=p.charAt(i);//逐个拆分出一个个char字节
                nd = nd.createNextNew(c); //构建出下一个TrieNode
                if (nd.Layer == 0) {
                    nd.Layer = j + 1;//记录当前TrieNode(即char字节)在字符串中position
                    //记录同一个Position的TrieNodes
                    if (!allNodeLayers.containsKey(nd.Layer) ) {
                        List<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode> nodes = new ArrayList<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode>();
                        nodes.add(nd);
                        allNodeLayers.put(nd.Layer, nodes);
                    } else {
                        allNodeLayers.get(nd.Layer).add(nd);
                    }
                }
            }
            //每个字符串的最后一个char字节记录，在字符串数组中的位置。
            nd.SetResults(i);
        }

        List<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode> allNode = new ArrayList<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode>();
        allNode.add(root);
        //将全部字符串拆分出来的TrieNode(即字节char)都收集起来
        for (int i = 0; i < allNodeLayers.size(); i++) { // 注意 这里不能用 keySet()
            List<com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode> nodes = allNodeLayers.get(i + 1); //获取到同一个position的TrieNode集合
            for (int j = 0; j < nodes.size(); j++) {
                allNode.add(nodes.get(j));
            }
        }
        allNodeLayers.clear();
        allNodeLayers = null;

        for (int i = 1; i < allNode.size(); i++) {
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode nd = allNode.get(i);
            nd.Index = i;
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode r = nd.Parent.Failure;
            Character c = nd.Char;
            while (r != null && !r.m_values.containsKey(c))
                r = r.Failure;
            if (r == null)
                nd.Failure = root;
            else {
                nd.Failure = r.m_values.get(c);
                for (Integer result : nd.Failure.Results) {
                    nd.SetResults(result);
                }
            }
        }
        root.Failure = root;

        List<TrieNode2> allNode2 = new ArrayList<TrieNode2>();
        for (int i = 0; i < allNode.size(); i++) {
            allNode2.add(new TrieNode2());
        }
        for (int i = 0; i < allNode2.size(); i++) {
            com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode oldNode = allNode.get(i);
            TrieNode2 newNode = allNode2.get(i);

            for (Character key : oldNode.m_values.keySet()) {
                com.leimans.sensitivewordlib.toolgood.core.internals.TrieNode nd = oldNode.m_values.get(key);
                newNode.Add(key, allNode2.get(nd.Index));
            }
            List<Integer> integerList=  oldNode.Results;
            for (Integer item:integerList){
                newNode.SetResults(item);
            }
            oldNode = oldNode.Failure;
            while (oldNode != root) {
                for (Character key : oldNode.m_values.keySet()) {
                    TrieNode nd = oldNode.m_values.get(key);
                    if (newNode.HasKey(key) == false) {
                        newNode.Add(key, allNode2.get(nd.Index));
                    }
                }
                List<Integer> tempList=oldNode.Results;
                for (Integer item:tempList){
                    newNode.SetResults(item);
                }
                oldNode = oldNode.Failure;
            }
        }
        allNode.clear();
        allNode = null;
        root = null;

        TrieNode2[] first = new TrieNode2[Character.MAX_VALUE + 1];
        TrieNode2 root2 = allNode2.get(0);
        for (Character key : root2.m_values.keySet()) {
            TrieNode2 nd = root2.m_values.get(key);
            first[(int) key] = nd;
        }
        _first = first;
    }


}