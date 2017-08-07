package com.exams.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppLocale {
    private String img;
    private String title;

    public AppLocale(String title, String img) {
        this.img = img;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppLocale appLocal = (AppLocale) o;

        if (img != null ? !img.equals(appLocal.img) : appLocal.img != null) return false;
        return title != null ? title.equals(appLocal.title) : appLocal.title == null;
    }

    @Override
    public int hashCode() {
        int result = img != null ? img.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
