package com.example.sdfernandobrizuela.controllers;

import com.example.sdfernandobrizuela.dtos.cliente.ClienteDto;
import com.example.sdfernandobrizuela.interfaces.IController;
import com.example.sdfernandobrizuela.interfaces.IService;
import com.example.sdfernandobrizuela.services.ClienteService;
import com.example.sdfernandobrizuela.utils.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements IController<ClienteDto> {

    ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity create(@RequestBody ClienteDto clienteDto) {
        ClienteDto cliente = clienteService.create(clienteDto);
        return ResponseEntity.ok(cliente);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity getById(@PathVariable Integer id) {
        ClienteDto cliente = clienteService.getById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado el cliente con id: " + id);
    }

    @Override
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/pages/{page_num}")
    public ResponseEntity<Map<String, Object>> getAll(@PathVariable(value = "page_num") Integer page) {
        Pageable pag = PageRequest.of(page - 1, Setting.PAGE_SIZE);

        Page ClienteDto = clienteService.getAll(pag);

        Map<String, Object> response = new HashMap<>();
        response.put("clientes", ClienteDto.getContent());
        response.put("currentPage", ClienteDto.getNumber() + 1);
        response.put("totalItems", ClienteDto.getTotalElements());
        response.put("totalPages", ClienteDto.getTotalPages());

        return ResponseEntity.ok(response);

    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/nombre/{nombre}/pages/{page_num}")
    public ResponseEntity<Map<String, Object>>  searchByName(@PathVariable String nombre, @PathVariable(value = "page_num") Integer page) {
        Pageable pag = PageRequest.of(page - 1, Setting.PAGE_SIZE);

        Page ClienteDto = clienteService.searchByName(nombre, pag);

        Map<String, Object> response = new HashMap<>();
        response.put("clientes", ClienteDto.getContent());
        response.put("currentPage", ClienteDto.getNumber() + 1);
        response.put("totalItems", ClienteDto.getTotalElements());
        response.put("totalPages", ClienteDto.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/ruc/{ruc}/pages/{page_num}")
    public ResponseEntity<Map<String, Object>>  searchByRuc(@PathVariable String ruc, @PathVariable(value = "page_num") Integer page) {
        Pageable pag = PageRequest.of(page - 1, Setting.PAGE_SIZE);

        Page ClienteDto = clienteService.searchByRuc(ruc, pag);

        Map<String, Object> response = new HashMap<>();
        response.put("clientes", ClienteDto.getContent());
        response.put("currentPage", ClienteDto.getNumber() + 1);
        response.put("totalItems", ClienteDto.getTotalElements());
        response.put("totalPages", ClienteDto.getTotalPages());

        return ResponseEntity.ok(response);
    }
    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ClienteDto clienteDto) {
        ClienteDto cliente = clienteService.update(id, clienteDto);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado el cliente con id: " + id);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (clienteService.delete(id)) {
            return ResponseEntity.ok("Se ha eliminado al usuario con id " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado el cliente con id: " + id);
    }
}
