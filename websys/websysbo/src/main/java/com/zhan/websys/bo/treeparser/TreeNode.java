package com.zhan.websys.bo.treeparser;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TreeNode implements Serializable {

    private static final long serialVersionUID = -4397560948579039772L;

    private String id;

    private String title;

    private String checked;

    private String pid;

    private String url;

    private Map<String, String> extraAttributes;

    private List<TreeNode> children;

    public void addChild(TreeNode node) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(node);
    }
}
