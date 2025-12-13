package com.example.demo.utils;

import org.springframework.data.domain.Sort;

public enum ProductSorting {
  NAME_ASC("titleAsc", Sort.by("title").ascending()),
  NAME_DESC("titleDesc", Sort.by("title").descending()),
  COST_ASC("costAsc", Sort.by("cost").ascending()),
  COST_DESC("costDesc", Sort.by("cost").descending());

  private final String code;
  private final Sort sort;

  ProductSorting(String code, Sort sort) {
    this.code = code;
    this.sort = sort;
  }

  public String getCode() {
    return this.code;
  }

  public Sort sort() {
    return this.sort;
  }

  public static Sort fromCode(String code) {
    for (ProductSorting ps: values()) {
      if (ps.code.equals(code)) {
        return ps.sort;
      }
    }

    return Sort.unsorted();
  }
}
