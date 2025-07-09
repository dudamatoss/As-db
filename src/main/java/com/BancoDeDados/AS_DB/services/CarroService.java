package com.BancoDeDados.AS_DB.services;

import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.repositories.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarTodosCarros(){
        return this.carroRepository.findAll();
    }

    public Carro listarPorId (int id) {
        return this.carroRepository.findById(id).orElseThrow();
    }

    public Carro criarCarro (Carro carroRequest){
        return this.carroRepository.save(carroRequest);
    }

//    public Carro editarCarro (Carro carroRequest, int id){
//        return this.carroRepository.editarCarro(carroRequest, id);
//    }
    public void updateCarro(int id, Carro carroRequest){
        Carro carro = this.carroRepository.getReferenceById(id);

        carro.setModelo(carroRequest.getModelo());
        carro.setAno(carroRequest.getAno());
        carro.setMarca(carroRequest.getMarca());
        carro.setPlaca(carroRequest.getPlaca());
        carro.setPreco(carroRequest.getPreco());
        carro.setStatus(carroRequest.getStatus());


        this.carroRepository.save(carro);
    }


    public void deleteCarro (int id){
        Carro carro = this.carroRepository.getReferenceById(id);
        this.carroRepository.delete(carro);
    }
}

