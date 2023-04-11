package com.example.DisfracesFront.controller;


import com.example.DisfracesFront.models.Alquiler;
import com.example.DisfracesFront.models.Cliente;
import com.example.DisfracesFront.models.Disfraz;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/app")
public class IndexController {
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;


    List<Disfraz> disfrazs= new ArrayList<>();
    List<Cliente> clientes= new ArrayList<>();
    List<Alquiler> alquilers= new ArrayList<>();

    @GetMapping({"/index","/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Bienvenido a spring");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil (Model model){
        Cliente cliente = new Cliente();

        cliente.setApellidos_cliente("Garaicoa");
        cliente.setDireccion_cliente("Miraflores");
        cliente.setEstado_cliente(true);
        cliente.setNombres_cliente("Christian");
        cliente.setCedula("0105578173");
        cliente.setId_cliente(1L);
        model.addAttribute("cliente",cliente);
        model.addAttribute("titulo",textoIndex.concat(" "+ cliente.getNombres_cliente()));
        model.addAttribute("clientes", clientes);

        return "ListaCliente";
    }

     @GetMapping("/mix-params")
     public String param(@RequestParam String nombres,@RequestParam Boolean estado, Model model ){
        if(estado==true){
            model.addAttribute("resultado", "El cliente seleccionado es "+ nombres + " y se encuentra activo");
        }else{
            model.addAttribute("resultado", "El cliente seleccionado es "+ nombres + " y se encuentra inactivo");

        }
        return "params/mixparams";
     }

    @RequestMapping("/disfraz")
    public String disfraz(Model model){

        Disfraz disfraz = new Disfraz(1L,"dis001", "Disfraz de cholo" , 3.15, "Teatrales" );
        Disfraz disfraz1 = new Disfraz(2L,"dis002", "Disfraz de chola" , 4.90, "Teatrales" );



        disfrazs.add(disfraz);
        disfrazs.add(disfraz1);

        model.addAttribute("disfraz", disfrazs);

        return "ListaDisfraz";
    }

    @RequestMapping("/alquiler")
    public String alquiler(Model model) throws ParseException {
        String dateString = "2023-04-08";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        Date date2 = dateFormat.parse("2023-06-12");

        Cliente c = new Cliente(2L,"0123456789","Myrian", "Cutiopala", "Feria Libre","chrisfercarabajo@gmail.com", 18,false);
        Disfraz disfraz1 = new Disfraz(2L,"dis002", "Disfraz de chola" , 4.90, "Teatrales" );
        Alquiler a= new Alquiler(1L,c,disfraz1,date,date2,"Ropa en buen estado", 5,12.50 );

        Disfraz disfraz = new Disfraz(1L,"dis001", "Disfraz de cholo" , 3.15, "Teatrales" );
        Cliente c1 = new Cliente(2L,"0123456789","Christian", "Garaicoa", "Miraflores","myrian@gmail.com",20, true);
        Alquiler a1= new Alquiler(2L,c1,disfraz,dateFormat.parse("2023-06-12"),dateFormat.parse("2023-07-12"),"Ropa en buen estado", 5,12.50 );


        alquilers.add(a);
        alquilers.add(a1);

        model.addAttribute("alquiler", alquilers);

        return "ListaAlquiler";
    }

    @GetMapping("/paht/{texto}")
    public String path(@PathVariable int texto,Model model){
        Alquiler a=null;
        System.out.println(texto);
        for(Alquiler d: alquilers){
            if(d.getId_alquiler()==texto){
                a=d;
                break;
            }
        }
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = outputDateFormat.format(a.getFecha_prestamo());
        String formattedDate2 = outputDateFormat.format(a.getFecha_devolucion());

       model.addAttribute("resultado","El cliente: "+ a.getCliente().getNombres_cliente()+" "+
               a.getCliente().getApellidos_cliente()+" realiza el prestamo en la fecha "+formattedDate+
                " y tiene que devolver la fecha "+formattedDate2);
        return "params/path";
    }



    @GetMapping("/requestparam")
    public String request(@RequestParam(name="texto", required = false, defaultValue = "cualquier valor")int texto , Model model){
        Disfraz disfraz=null;
        System.out.println(disfrazs.size());
        for(Disfraz d: disfrazs){
            if(d.getId_disfraz()==texto){
                disfraz=d;
                break;
            }
        }

        model.addAttribute("resultado",disfraz);
        return "params/ver";
    }

    @GetMapping("/ruta")
    public String ruta(){
        return "redirect:http://localhost:8080/app/disfraz";
    }


    @GetMapping("/form")
    public String form(Model model){
        Cliente cliente=new Cliente();
        model.addAttribute("cliente", cliente);
        return "index";
    }
    @PostMapping("/form")
    public String procesar(@Valid Cliente cliente, BindingResult result, Model model){

        if(result.hasErrors()){

            return "index";
        }
        int id=clientes.size()+1;
        long idl=(long) id;

        model.addAttribute("cliente", cliente);
        cliente.setEstado_cliente(true);
        cliente.setId_cliente(idl);
        clientes.add(cliente);
        return "resultado";
    }


}
