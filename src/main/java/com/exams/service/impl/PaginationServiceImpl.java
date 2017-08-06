package com.exams.service.impl;

import com.exams.service.PaginationService;
import lombok.ToString;

@ToString
public class PaginationServiceImpl implements PaginationService {

	private int showPages;
	private int interval;
	private int countPages;
	private int current;
	private int start;
	private int end;
	private String url;

	public PaginationServiceImpl(int showPages, int countPages, int current, String url) {
		this.url = url;
		this.showPages = showPages;
		this.countPages = countPages;
		this.current = current;
		interval = showPages / 2;
		calculate();
	}

	private void calculate() {
		if (countPages <= showPages) {
			start = 1;
			end = countPages;
		} else {

			if (current <= interval + 1) {
				start = 1;
				end = showPages;
			} else {
				if (current + interval > countPages) {
					start = countPages - showPages + 1;
					end = countPages;
				} else {
					start = current - interval;
					end = current + interval;
				}
			}
		}
	}

	@Override
	public int getCountPages() {
		return countPages;
	}

	@Override
	public int getCurrent() {
		return current;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public int getStart() {
		return start;
	}

	@Override
	public int getEnd() {
		return end;
	}

}
