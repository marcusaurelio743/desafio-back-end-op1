package cadastroUsuario.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cadastroUsuario.exeption.ExecaoGenerica;
import cadastroUsuario.model.Usuario;
import cadastroUsuario.repository.UsuarioRepository;

@RestController
@RequestMapping("api/auth")
@CrossOrigin
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario request) {

    	Usuario userOpt = usuarioRepository.findByUsuario(request.getUsuario());

        // Se NÃO encontrar o usuário
        if (userOpt == null) {
            return ResponseEntity
                    .status(401)
                    .body(new ExecaoGenerica("Usuário não encontrado."));
        }

        Usuario user = userOpt;

        // Se a senha estiver incorreta
        if (!user.getSenha().equals(request.getSenha())) {
            return ResponseEntity
                    .status(401)
                    .body(new ExecaoGenerica("Senha incorreta."));
        }

        // Se tudo OK
        return ResponseEntity.ok(Map.of(
                "message", "Login realizado com sucesso!",
                "token", "fake-token",
                "perfil", userOpt.getPerfil()
        ));
    }
    
}
