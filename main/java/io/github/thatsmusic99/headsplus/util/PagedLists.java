package io.github.thatsmusic99.headsplus.util;

import java.util.List;

public class PagedLists {

    // Util by Thatsmusic99

    private List<?> list;
    private int pages;
    private int contents;
    private int currentPage;
    private int contentsPerPage;

    public PagedLists(List<?> list, int contentsPerPage) {
        if (contentsPerPage < 1) {
            throw new IllegalArgumentException("The provided int must be bigger than 0 for contents per page!");
        }
        this.list = list;
        int pages = 1;
        int bls = list.size();
        while (bls > contentsPerPage) {
            pages++;
            bls = bls - contentsPerPage;
        }
        this.pages = pages;
        this.contents = list.size();
        this.currentPage = 1;
        this.contentsPerPage = contentsPerPage;
    }

    public int getTotalPages() {
        return pages;
    }

    public int getTotalContents() {
        return contents;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public List<?> getList() {
        return list;
    }

    public List<?> getContentsInPage(int page) {
        if (page > getTotalPages()) {
            throw new IllegalArgumentException("The provided page is an int larger than the total number of pages!");
        }
        int sIndex = (page - 1) * getContentsPerPage();
        int eIndex = getContentsPerPage() + sIndex;
        if (eIndex > getList().size()) {
            eIndex = getList().size();
        }
        setPage(page);
        return getList().subList(sIndex, eIndex);
    }

    private void setPage(int page) {
        this.currentPage = page;
    }

    public int getContentsPerPage() {
        return contentsPerPage;
    }

}
