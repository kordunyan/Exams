package com.exams.service;

public interface PaginationService {
	int getStart();

	int getEnd();

	int getCountPages();

	int getCurrent();

	String getUrl();
}
