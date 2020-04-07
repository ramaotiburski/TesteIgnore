/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.slo.tecinfo.devweb.controller;

import br.edu.ifsc.slo.tecinfo.devweb.model.Produto;
import br.edu.ifsc.slo.tecinfo.devweb.repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ramao
 */
@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    //ArrayList<Produto> produtos = new ArrayList<>();
    private final ProdutoRepository produtoRepositorio;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @GetMapping("/listar")
    public String getProdutos(Model model) {
        model.addAttribute("produtos", produtoRepositorio.findAll());
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Produto produto) {
        return "add-produto";
    }

    @PostMapping("/adicionar")
    public String addProduto(@Valid Produto produto) {
        produtoRepositorio.save(produto);
        return "redirect:listar";
    }
    
    @GetMapping("/editar/{codigo}")
	public String showUpdateFormProduto(@PathVariable("codigo") int codigo, Model model) {
		 Produto produto = produtoRepositorio.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Código de usuario inválido:" + codigo));
		model.addAttribute("produto", produto);
		return "update-produto";
	}
    
    @PostMapping("/update/{codigo}")
        public String updateProduto(@PathVariable("codigo") int codigo,@Valid Produto produto, Model model) {
            //stringToDate(produto.getValidade().toString());
            produtoRepositorio.save(produto);
            return "redirect:/produtos/listar";
        }

    @GetMapping("apagar/{codigo}")
    public String deleteProduto(@PathVariable("codigo") int codigo, Model model) {
        Produto produto = produtoRepositorio.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Código de produto inválido:" + codigo));
        produtoRepositorio.delete(produto);
        model.addAttribute("produtos", produtoRepositorio.findAll());
        return "index";
    }
    
    public Date stringToDate(String dataString){
        
        return null;
    }

}
