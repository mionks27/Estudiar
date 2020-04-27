package sw2.tarea.lab1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sw2.tarea.lab1.Entity.CompraRealizada;
import sw2.tarea.lab1.Entity.Producto;
import sw2.tarea.lab1.Repository.CompraRealizadaRepository;
import sw2.tarea.lab1.Repository.ProductoRepository;

import java.util.*;

@Controller
public class CompraRealizadaController {

    @Autowired
    CompraRealizadaRepository compraRealizadaRepository;
    @Autowired
    ProductoRepository productoRepository;

    @GetMapping(value = {"","/lista"})
        public String inicio(Model model) {
            List<CompraRealizada> listaDeCompras = compraRealizadaRepository.findAll();
            model.addAttribute("lista", listaDeCompras);
            return "index";
    }

    @GetMapping("/editar")
    public String editarTerritorio(Model model,
                                   @RequestParam("id") int id){
        Optional<CompraRealizada> compra = compraRealizadaRepository.findById(id);

        if(compra.isPresent()) {
            CompraRealizada compra2 = compra.get();
            List<Producto> listaDePoductos = productoRepository.findAll();
            List<String> malls = new ArrayList<>();
            List<String> metodos = new ArrayList<>();
            metodos.add("Efectivo");
            metodos.add("Tarjeta de crédito o débito");
            metodos.add("Paypal");
            malls.add("Wong");
            malls.add("Plaza Vea");
            malls.add("Tottus");
            malls.add("Metro");
            malls.add("Vivanda");
            model.addAttribute("listaMalls",malls);
            model.addAttribute("listametodos",metodos);
            model.addAttribute("lista",listaDePoductos);
            model.addAttribute("compra",compra2);
            return "editar";
        }else {
            return "redirect:/lista";
        }
    }

    @GetMapping("/borrar")
    public String borrarTerritorio(@RequestParam("id") int id) {
        Optional<CompraRealizada> compra = compraRealizadaRepository.findById(id);
        if(compra.isPresent()) {
            compraRealizadaRepository.deleteById(id);
        }
        return "redirect:/lista";
    }

    @PostMapping("/guardar")
    public String actualizarTerritorio(CompraRealizada compra) {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        System.out.println("Fecha Actual: "
                + dia + "/" + (mes+1) + "/" + año);
        System.out.printf("Hora Actual: %02d:%02d:%02d %n",
                hora, minuto, segundo);
        String fechaActual = año + "-" + (mes+1) + "-" + dia + " " + hora + ":"+minuto+":"+segundo;
        compra.setFechadelacompra(fechaActual);
        compraRealizadaRepository.save(compra);
        return "redirect:/lista";
    }

    @GetMapping("/nuevo")
    public String crear(Model model){
        List<Producto> listaDeProductos = productoRepository.findAll();
        List<String> malls = new ArrayList<>();
        List<String> metodos = new ArrayList<>();
        metodos.add("Efectivo");
        metodos.add("Tarjeta de crédito o débito");
        metodos.add("Paypal");
        malls.add("Wong");
        malls.add("Plaza Vea");
        malls.add("Tottus");
        malls.add("Metro");
        malls.add("Vivanda");
        model.addAttribute("listaMalls",malls);
        model.addAttribute("listametodos",metodos);
        model.addAttribute("lista",listaDeProductos);
        return "crear";

    }

}
