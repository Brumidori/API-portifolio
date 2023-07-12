package br.com.igbr.portfolioApi.service;

import br.com.igbr.portfolioApi.dto.TagDTO;
import br.com.igbr.portfolioApi.model.TagModel;
import br.com.igbr.portfolioApi.repository.TagRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagDTO> findAll() {
        List<TagModel> result =  tagRepository.findAll();
        List<TagDTO> dtoList = result.stream().map(TagDTO:: new).toList();
        return dtoList;
    }

    public Optional<TagDTO> findById(Long id) {
        TagModel model = tagRepository.findById(id).get();
        TagDTO dto = new TagDTO(model);
        return Optional.of(dto);
    }

    public TagDTO save(TagModel tag) {
        TagModel model = tagRepository.save(tag);
        return new TagDTO(model);
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
}
