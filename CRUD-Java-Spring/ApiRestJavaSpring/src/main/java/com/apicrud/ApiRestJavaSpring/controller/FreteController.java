package com.apicrud.ApiRestJavaSpring.controller;

import com.apicrud.ApiRestJavaSpring.model.Frete;
import com.apicrud.ApiRestJavaSpring.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
public class FreteController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/buscar-fretes/{destino}")
    public Page<Frete> retornaFretePorDestino(
            @PathVariable("destino") String destino,
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanhoPagina", defaultValue = "10") int tamanhoPagina) {

        PageRequest pageable = PageRequest.of(pagina, tamanhoPagina);
        return mySqlRepository.retornaFretePorDestino(destino, pageable);
    }

    @DeleteMapping("/remover-frete/{id}")
    public boolean removerFrete(@PathVariable("id") Integer id){
        if(!mySqlRepository.findById(id).equals(Optional.empty())){
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/atualiza-dados-frete/{id}")
    public Frete atualizaDadosFrete(@PathVariable("id") Integer id,
                                    @RequestBody Map<String, String> body){
        Frete frete = mySqlRepository.findById(id).get();

        frete.setOrigem(body.get("origem"));
        frete.setDestino(body.get("destino"));
        frete.setDistanciaKm(new BigDecimal(body.get("distanciaKm")));
        frete.setValorFrete(new BigDecimal(body.get("valorFrete")));
        frete.setDataContrato(tratarData(body.get("dataContrato")));
        frete.setStatus(body.get("status"));

        mySqlRepository.save(frete);

        return frete;
    }

    @PostMapping("/adicionar-frete")
    public Frete adicionarFrete(@RequestBody Map<String, String> body){
        String origem = body.get("origem");
        String destino = body.get("destino");
        BigDecimal distanciaKM = new BigDecimal(body.get("distanciaKM"));
        BigDecimal valorFrete = new BigDecimal(body.get("valorFrete"));
        Date dataContrato = tratarData(body.get("dataContrato"));
        String status = body.get("status");

        Frete novoFrete = new Frete(origem, destino, distanciaKM, valorFrete, dataContrato, status);

        return mySqlRepository.save(novoFrete);
    }

    public Date tratarData(String data) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace(); // Trate a exceção adequadamente conforme sua aplicação
            return null;
        }
    }
}
