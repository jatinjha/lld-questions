package com.jatin.inventorymanagmentsystem.services;

import com.jatin.inventorymanagmentsystem.models.Product;
import com.jatin.inventorymanagmentsystem.models.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryService {
    Map<ProductCategory,List<Product>> productCategoryVsProduct;

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryVsProduct.keySet().stream().toList();
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        for (ProductCategory productCategory : productCategoryList){
            productCategoryVsProduct.computeIfAbsent(productCategory,key->new ArrayList<>()).addAll(productCategory.getProductList());
        }
    }

    public void addProduct(ProductCategory productCategory , Product product){
        productCategoryVsProduct.get(productCategory).add(product);
        productCategory.addProduct(product);
    }

    public void removeProduct(ProductCategory productCategory , Product product){
        List<Product> productList = productCategoryVsProduct.get(productCategory);
        productList.removeIf(productObj->productObj.equals(product));
        productCategory.getProductList().remove(product);
    }


}
