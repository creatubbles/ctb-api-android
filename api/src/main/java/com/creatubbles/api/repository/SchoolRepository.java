package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * @author Pawel Szymanski
 */
public interface SchoolRepository {

    void search(@Nullable Integer page, @NonNull SchoolQuery query, @Nullable ResponseCallback<CreatubblesResponse<List<School>>> callback);


    class SchoolQuery {
        private String nameContaining;
        private String countryCode;
        private int[] ids;

        public SchoolQuery nameContaining(@NonNull String nameContaining) {
            this.nameContaining = nameContaining;
            return this;
        }

        public SchoolQuery preferredCountryCode(@NonNull String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        void withIds(@NonNull int... ids) {
            this.ids = ids;
        }

        String getNameContaining() {
            return nameContaining;
        }

        String getCountryCode() {
            return countryCode;
        }

        int[] getIds() {
            return ids;
        }
    }
}
