package com.fil.sra.dto;


import com.fil.sra.models.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class ResearchArticleRequestDto {
    private List<String> categories;
    private String subName;
    private int paginationSize;
    private int pageNumber;
    private Integer articleId;
}
