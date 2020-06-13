/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;


import com.mycompany.GUI.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;


import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.mycompany.Entity.Paiement1;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class ServicePaiement {
    public boolean payer(String numeroCarte,int moisExp,int anneeExp,String cvc,int montant,String description) throws  com.stripe.exception.AuthenticationException,  InvalidRequestException,StripeException, CardException
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> tokenParams = new HashMap<>();
        Map<String, Object> cardParams = new HashMap<>();
        Paiement1 p = new Paiement1();
        Stripe.apiKey = p.getApiKey();
        cardParams.put("number", numeroCarte);
        cardParams.put("exp_month", moisExp);
        cardParams.put("exp_year", anneeExp);
        cardParams.put("cvc", cvc);
        int nMontant= montant*100;
        tokenParams.put("card", cardParams);
        Token token =Token.create(tokenParams);
        if (token.getId()!=null){
        params.put("amount", nMontant);
        params.put("currency", "usd");
        params.put("description", description);
        params.put("source", token.getId());
        Charge charge = Charge.create(params);
        }
        else 
            return false;
        return true; 
    }
}