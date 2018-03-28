/** 
 * <pre>��Ŀ����:fenye 
 * �ļ�����:PageFlag.java 
 * ����:com.jk.model 
 * ��������:2017-9-22����4:44:51 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.util.List;


public class PageFlag {
	   //��ǰҳ
		private Integer pageIndex = 1;
		
		//ÿҳ����
		private Integer pageSize = 2;
		
		//�ܼ�¼��
		private long dataTotal;
		
		//ʣ���¼��
		private long dataResidue;
		
		//��ҳ��
		private long pageTotal;
		
		//��ǰҳ
		private List<Integer> currentPageList;

		public Integer getPageIndex() {
			return pageIndex;
		}

		public void setPageIndex(Integer pageIndex) {
			this.pageIndex = pageIndex;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

		public long getDataTotal() {
			return dataTotal;
		}

		public void setDataTotal(long dataTotal) {
			this.dataTotal = dataTotal;
		}

		public long getDataResidue() {
			return dataResidue;
		}

		public void setDataResidue(long dataResidue) {
			this.dataResidue = dataResidue;
		}

		public long getPageTotal() {
			return pageTotal;
		}

		public void setPageTotal(long pageTotal) {
			this.pageTotal = pageTotal;
		}

		public List<Integer> getCurrentPageList() {
			return currentPageList;
		}

		public void setCurrentPageList(List<Integer> currentPageList) {
			this.currentPageList = currentPageList;
		}

		public PageFlag() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PageFlag(Integer pageIndex, Integer pageSize, long dataTotal,
				long dataResidue, long pageTotal, List<Integer> currentPageList) {
			super();
			this.pageIndex = pageIndex;
			this.pageSize = pageSize;
			this.dataTotal = dataTotal;
			this.dataResidue = dataResidue;
			this.pageTotal = pageTotal;
			this.currentPageList = currentPageList;
		}

		@Override
		public String toString() {
			return "PageFlag [pageIndex=" + pageIndex + ", pageSize="
					+ pageSize + ", dataTotal=" + dataTotal + ", dataResidue="
					+ dataResidue + ", pageTotal=" + pageTotal
					+ ", currentPageList=" + currentPageList + "]";
		}
		
		
		
		
}
