package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {

      var data = clienteRepository.save(cliente);
      return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
      var data = clienteRepository.findAll();
      return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        var data = clienteRepository.findById(idClient);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removerCliente(@PathVariable("id") Long idClient) {

        clienteRepository.deleteById(idClient);

        return "Cliente deletado com sucesso";
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {

                clienteRepository.findById(id)
                    .map(record -> {
                        record.setNome(cliente.getNome());
                        record.setEmail(cliente.getEmail());
                        record.setEnderecoList(cliente.getEnderecoList());
                        record.setIdade(cliente.getIdade());
                        record.setTelefoneList(cliente.getTelefoneList());
                        Cliente updated = clienteRepository.save(record);
                        return ResponseEntity.ok().body(updated);
                    }).orElse(ResponseEntity.notFound().build());

        }


    }



