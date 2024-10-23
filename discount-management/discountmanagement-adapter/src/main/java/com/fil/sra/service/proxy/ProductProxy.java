package com.fil.sra.service.proxy;

import com.fil.sra.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductProxy extends Proxy{

    @Value("${product-referencement.api.url}")
    private String apiUrl;
    public ProductProxy(RestTemplate rest) {
        super(rest);
    }

    public List<ProductDto> getProductsByPage(String ean, String subName, List<String> categories, int paginationSize, int pageNumber) {
        String urlRequest = apiUrl + "/admin/articles/search";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlRequest);
        if (ean != null) {
            builder.queryParam("ean", ean);
        } if (subName != null) {
            builder.queryParam("subName", subName);
        }
        if (categories != null && !categories.isEmpty()) {
            builder.queryParam("categories", String.join(",", categories));
        }
        builder.queryParam("paginationSize", paginationSize);
        builder.queryParam("pageNumber", pageNumber);

        Type responseType = new ParameterizedTypeReference<List<ProductDto>>() {}.getType();
        String uri =  builder.toUriString();
        System.out.println(uri);
        return super.getParametizeTemplateList(uri, responseType);
    }

}
