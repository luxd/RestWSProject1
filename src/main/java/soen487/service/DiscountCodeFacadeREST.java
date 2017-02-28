/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soen487.service;

import soen487.DiscountCode;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author ericl
 */
//@Stateless
@Path("discountcode")
public class DiscountCodeFacadeREST extends AbstractFacade<DiscountCode> {

    //@PersistenceContext(unitName = "NewTestPU")
    private EntityManager em = EMF.createEntityManager();;

    public DiscountCodeFacadeREST() {
        super(DiscountCode.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DiscountCode entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, DiscountCode entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DiscountCode find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiscountCode> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiscountCode> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    

    /**
     * Added part, to meet the requirement of Figure3
     * @param id
     * @return 
     */
    @GET
    @Path("listCustomer/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String listCustomersByCode(@PathParam("id") String id) {
        return super.find(id).getCustomerList();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
