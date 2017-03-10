
/**
 * EstoqueBOCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

    package com.fiap.estoquebo;

    /**
     *  EstoqueBOCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class EstoqueBOCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public EstoqueBOCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public EstoqueBOCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getLista method
            * override this method for handling normal response from getLista operation
            */
           public void receiveResultgetLista(
                    com.fiap.estoquebo.EstoqueBOStub.GetListaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLista operation
           */
            public void receiveErrorgetLista(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for consultarProduto method
            * override this method for handling normal response from consultarProduto operation
            */
           public void receiveResultconsultarProduto(
                    com.fiap.estoquebo.EstoqueBOStub.ConsultarProdutoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from consultarProduto operation
           */
            public void receiveErrorconsultarProduto(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                


    }
    