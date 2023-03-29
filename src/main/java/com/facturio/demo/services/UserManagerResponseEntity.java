package com.facturio.demo.services;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public class UserManagerResponseEntity {

    /**
     * Returne une réponse de succés avec un statu de type 20x
     *
     * @param status est le status de la reponse HTTP
     * @param data   est la donnee a envoyer au client
     * @param <T>
     * @return est la réponse envoyer au client
     */
    public static <T> ResponseEntity<?> OKResponse(int status, T data) {
        // creer un objet JSON
        JSONObject response = new JSONObject();
        response.put("data", data); // ajouter la donnee
        response.put("status", status); // aucune erreur
        return org.springframework.http.ResponseEntity.status(status).body(response.toMap()); // ajouter toMap pour convertir en string
    }

    /**
     * Retourne une reponse d'echec avec un status de type 50X ou 40X
     *
     * @param status est le status  de la reponse HTTP
     * @param data   est la donnee a envoyer au client
     * @param <T>    est le type du deuxieme parametre de la fontion
     * @return est la reponse finale a envoyer au client
     */
    public static <T> ResponseEntity<?> errorResponse(int status, T data) {
        // creer un objet JSON
        JSONObject response = new JSONObject();
        response.put("message", data); // ajouter la donnee
        response.put("error", true); // aucune erreur
        return ResponseEntity.status(status).body(response.toMap());
    }
}
