package com.fil.sra.service.proxy;

public class ProductProxy extends Proxy{
    public List<Expense> getExpenses(){
        String url = this.props.getApiUrl()+"/expenses";
        disp(url);
        return super.getParametizeTemplate(url);
    }
}
