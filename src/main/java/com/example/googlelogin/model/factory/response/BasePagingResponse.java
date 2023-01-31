package com.example.googlelogin.model.factory.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BasePagingResponse<T extends Serializable> implements Serializable {

    private ArrayList<T> contents;

    private int pageNumber;

    private int pageSize;

    private long totalElement;

    public BasePagingResponse(List<T> contents, int pageNumber, int pageSize, long totalElement) {
        this.contents = new ArrayList<>(contents);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElement = totalElement;
    }

    public static <T extends Serializable> BasePagingResponseBuilder<T> builder() {
        return new BasePagingResponseBuilder<>();
    }

    public List<T> getContents() {
        return contents;
    }

    public static class BasePagingResponseBuilder<T extends Serializable> {
        private List<T> contents;
        private int pageNumber;
        private int pageSize;
        private long totalElement;

        public BasePagingResponseBuilder() {
        }

        public BasePagingResponse.BasePagingResponseBuilder<T> contents(List<T> contents) {
            this.contents = contents;
            return this;
        }

        public BasePagingResponse.BasePagingResponseBuilder<T> pageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public BasePagingResponse.BasePagingResponseBuilder<T> pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public BasePagingResponse.BasePagingResponseBuilder<T> totalElement(long totalElement) {
            this.totalElement = totalElement;
            return this;
        }

        public BasePagingResponse<T> build() {
            return new BasePagingResponse<>(this.contents, this.pageNumber, this.pageSize, this.totalElement);
        }

        @Override
        public String toString() {
            return """
                    BasePagingResponseBuilder {
                        contents = %s,
                        pageNumber = %s,
                        pageSize = %s,
                        totalElement = %s
                    """.formatted(contents, pageNumber, pageSize, totalElement);
        }
    }
}
