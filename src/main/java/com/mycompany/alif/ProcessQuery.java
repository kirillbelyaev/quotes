/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alif;

import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


//@Path("/getquote")
@Path("/")

/**
 *
 * @author kirill
 */
public class ProcessQuery {

    public ProcessQuery() {
        QS = new QuotesService();
        clock = new Scheduler(QS);
        ServletContextEvent event = null;
        
        clock.contextInitialized();
    }
    
    private QuotesService QS = null;
    private Scheduler clock = null;
    
    //private QuotesService QS = new QuotesService();
    //private Scheduler clock = new Scheduler();
    
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    @GET
    @Path("getsamplequote")
    @Produces({MediaType.APPLICATION_JSON})
    public Quote sendSampleQuote() {
        
        String author = "Jack London";
        String quote = "Famous quote from the past";
        String quote1 = "Famous quote from the future";
        String category = "daily";
        String ID = "1";
        
        Quote q = new Quote();
        
        q.setAuthor(author);
        q.setQuote(quote);
        q.setCategory(category);
        
        return q;      
    }

    @GET
    @Path("getallquotes")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Quote> getAllQuotes() {
        return QS.getAllQuotes();     
    }
    
    @GET
    @Path("getrandomquote")
    @Produces({MediaType.APPLICATION_JSON})
    public Quote getRandomQuote() {
        return QS.getRandomQuote();     
    }
    
    @GET
    //@Path("{getallquotesbycategory}")
    @Path("getallquotesbycategory/{category}")
    @Produces({MediaType.APPLICATION_JSON})
    //public Quote getAllQuotesByCategory(@PathParam("getallquotesbycategory") String category) {
    public List <Quote> getAllQuotesByCategory(@PathParam("category") String category) { 
        
        if (category == null || category.isEmpty()) return null;
        
        return QS.getAllQuotesByCategory(category);
    }
    
    @DELETE
    @Path("deletequote/{id}")
    public Response deleteQuote(@PathParam("id") String id) {
        if (QS.deleteQuote(id) == Constants.RETURN_CODES.SUCCESS.getValue() ) {
            return Response.status(202).entity("Quote with id " + id + " deleted successfully.").build();
        } else {
            //return Response.status(204).entity("Quote not found.").build();
            return Response.status(202).entity("Quote with id " + id + " not found.").build();
        }
    }
    
    @POST
    @Path("createquote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    //@Produces(MediaType.APPLICATION_XML) 
    //@Produces(MediaType.APPLICATION_JSON)
    public Response createQuote( Quote q ) {
        Response resp;
        
        if (q == null){
            resp = Response.status(202).entity(Constants.INVALID_OBJECT).build();
            return resp;
        }
        
        Quote quote = new Quote();
        quote = q;
        
        String id = q.getID();
        
        if (id == null || id.isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.ID_EMPTY).build();
              return resp;
        }
        
        if (q.getAuthor() == null || q.getAuthor().isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.AUTHOR_EMPTY).build();
              return resp;
        }
        
        if (q.getQuote()== null || q.getQuote().isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.QUOTE_EMPTY).build();
              return resp;
        }
        
        if (q.getCategory()== null || q.getCategory().isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.CATEGORY_EMPTY).build();
              return resp;
        }
        
        int ret = QS.createQuote(id, quote);
        
        if (ret != Constants.RETURN_CODES.SUCCESS.getValue()) {
            resp = Response.status(202).entity(Constants.OPERATION_FAIL).build();
            return resp;
        }
        
        //resp = Response.created(uriInfo.getAbsolutePath()).build();
        resp = Response.status(201).entity(Constants.OPERATION_SUCCESS).build();
 
        return resp;
    }
    
    @PUT
    @Path("editQuoteAuthor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    //@Produces(MediaType.APPLICATION_XML) 
    //@Produces(MediaType.APPLICATION_JSON)
    public Response editQuoteAuthor( Quote q ) {
        Response resp;
        
        if (q == null){
            resp = Response.status(202).entity(Constants.INVALID_OBJECT).build();
            return resp;
        }
        
        String id = q.getID();
        
        if (id == null || id.isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.ID_EMPTY).build();
              return resp;
        }
        
        if (q.getAuthor() == null || q.getAuthor().isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.AUTHOR_EMPTY).build();
              return resp;
        }
        
        int ret = QS.editQuoteAuthor(id, q.getAuthor());
        
        if (ret != Constants.RETURN_CODES.SUCCESS.getValue()) {
            resp = Response.status(202).entity(Constants.OPERATION_FAIL).build();
            return resp;
        }
        
        resp = Response.status(201).entity(Constants.OPERATION_SUCCESS).build();
 
        return resp;
    }
    
    @PUT
    @Path("editQuoteCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    //@Produces(MediaType.APPLICATION_XML) 
    //@Produces(MediaType.APPLICATION_JSON)
    public Response editQuoteCategory( Quote q ) {
        Response resp;
        
        if (q == null){
            resp = Response.status(202).entity(Constants.INVALID_OBJECT).build();
            return resp;
        }
        
        String id = q.getID();
        
        if (id == null || id.isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.ID_EMPTY).build();
              return resp;
        }
        
        if (q.getCategory()== null || q.getCategory().isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.CATEGORY_EMPTY).build();
              return resp;
        }
        
        int ret = QS.editQuoteCategory(id, q.getCategory());
        
        if (ret != Constants.RETURN_CODES.SUCCESS.getValue()) {
            resp = Response.status(202).entity(Constants.OPERATION_FAIL).build();
            return resp;
        }
        
        resp = Response.status(201).entity(Constants.OPERATION_SUCCESS).build();
 
        return resp;
    }
    
    @PUT
    @Path("editQuote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    //@Produces(MediaType.APPLICATION_XML) 
    //@Produces(MediaType.APPLICATION_JSON)
    public Response editQuote( Quote q ) {
        Response resp;
        
        if (q == null){
            resp = Response.status(202).entity(Constants.INVALID_OBJECT).build();
            return resp;
        }
        
        String id = q.getID();
        
        if (id == null || id.isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.ID_EMPTY).build();
              return resp;
        }
        
        if (q.getQuote()== null || q.getQuote().isEmpty()) {
            //resp = Response.noContent().build();
              resp = Response.status(400).entity(Constants.QUOTE_EMPTY).build();
              return resp;
        }
        
        int ret = QS.editQuote(id, q.getQuote());
        
        if (ret != Constants.RETURN_CODES.SUCCESS.getValue()) {
            resp = Response.status(202).entity(Constants.OPERATION_FAIL).build();
            return resp;
        }
        
        resp = Response.status(201).entity(Constants.OPERATION_SUCCESS).build();
 
        return resp;
    }
    
    
    @POST
    //@Path("/sconnect")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    public Response consumeJSON( String message ) {
 
        String output = message;
        System.out.println("message:" + output.toString());
 
        return Response.status(200).entity(output).build();
    }
    
    /* subpath */
    @POST
    @Path("sendxml")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    @Produces(MediaType.APPLICATION_XML) 
    public Quote sendTestXMLMessage( String dato ) {
     
        String quote = dato;
        String author = "Steve Jobs";
        String category = "daily";
        
        Quote q = new Quote();
        q.setAuthor(author);
        q.setCategory(category);
        q.setQuote(quote);
        
        return q;
    }
    
    /* subpath */
    @POST
    @Path("sendjson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    //@Produces(MediaType.APPLICATION_XML) 
    //@Produces(MediaType.APPLICATION_JSON)
    public Quote sendTestJSONMessage( String dato ) {
 
        String quote = dato;
        String author = "Steve Jobs";
        String category = "daily";
        
        Quote q = new Quote();
        q.setAuthor(author);
        q.setCategory(category);
        q.setQuote(quote);
        
        return q;
    }
    
}
