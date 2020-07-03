package com.dks.apilojavirtual.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsError {

    private String title;

    private Long status;

    private Long timestamp;
}
