package com.vision.erp.common;

public class Search {
   //field

   private String searchCondition;
   private String searchKeyword;
   private String usageCondition;
   private String minDate;
   private String maxDate;
   
   public String getSearchCondition() {
      return searchCondition;
   }
   public void setSearchCondition(String searchCondition) {
      this.searchCondition = searchCondition;
   }
   public String getSearchKeyword() {
      return searchKeyword;
   }
   public void setSearchKeyword(String searchKeyword) {
      this.searchKeyword = searchKeyword;
   }
   public String getUsageCondition() {
      return usageCondition;
   }
   public void setUsageCondition(String usageCondition) {
      this.usageCondition = usageCondition;
   }   
   public String getMinDate() {
      return minDate;
   }
   public void setMinDate(String minDate) {
      this.minDate = minDate;
   }
   public String getMaxDate() {
      return maxDate;
   }
   public void setMaxDate(String maxDate) {
      this.maxDate = maxDate;
   }
   
   @Override
   public String toString() {
      return "Search [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", usageCondition="
            + usageCondition + ", minDate=" + minDate + ", maxDate=" + maxDate + "]";
   }
   
}