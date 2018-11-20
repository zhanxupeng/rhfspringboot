package com.zhan.websys.bo.treeparser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TreeNodeBO {
    private String id;

    private String title;

    private String checked;

    private String pid;

    private String url;

    private List<TreeNodeBO> children;
}
