package com.conexionmysql.mysqljdb.labs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.aplication.services.$NAMETABLEF$Repository;
import com.conexionmysql.mysqljdb.domain.models.$NAMETABLEF$;

@RestController
@Validated
@RequestMapping("/api/$NAMETABLE$")

public class $TITLE$ {

  @Autowired
  private RoomRepository $NAMETABLE$Repository;

  @GetMapping
  public List<$NAMETABLEF$> getAll() {
    return $NAMETABLE$Repository.findAll();
  }

  @PostMapping
  public $NAMETABLEF$ create(@RequestBody $NAMETABLEF$ new$NAMETABLEF$ ) {
    return $NAMETABLE$Repository.save(newRoom);
  }

  @PutMapping("/{id}")
  public ResponseEntity<$NAMETABLEF$> update$NAMETABLEF$(@PathVariable Long id, @RequestBody $NAMETABLEF$ $NAMETABLE$) {
    Optional<$NAMETABLEF$> find$NAMETABLE$ = $NAMETABLE$Repository.findById(id);
    if (find$NAMETABLE$.isPresent()) {
      $NAMETABLE$.setRoom_id(id);
      try {
        $NAMETABLEF$ saved$NAMETABLEF$ = $NAMETABLE$Repository.save($NAMETABLE$);
        return new ResponseEntity<>(saved$NAMETABLEF$, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Optional<$NAMETABLEF$> find$NAMETABLE$ = $NAMETABLE$Repository.findById(id);
    Map<String, String> responseHash = new HashMap<>();
    if (find$NAMETABLE$.isPresent()) {
      $NAMETABLE$Repository.deleteById(id);
      responseHash.put("success", "$NAMETABLEF$ Deleted Successfully");

      return ResponseEntity.ok().body(responseHash);
    } else {
      responseHash.put("error", "$NAMETABLEF$ No found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHash);

    }
  }

}
