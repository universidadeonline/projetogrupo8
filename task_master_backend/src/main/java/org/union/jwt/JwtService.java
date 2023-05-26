// package org.union.jwt;

// import javax.enterprise.context.ApplicationScoped;
// import javax.inject.Inject;
// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response;

// @ApplicationScoped
// @Path("jwt")
// public class JwtService {
    
//     @Inject
//     JwtRepository jwtRepository;

//     @GET
//     @Produces(MediaType.TEXT_PLAIN)
//     public Response getJtw(){
//         String jwt = jwtRepository.generateJwt();
//         return Response.ok(jwt).build();
//     }
// }
