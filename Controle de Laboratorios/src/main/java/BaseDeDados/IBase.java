package BaseDeDados;

import java.util.List;

import entidades.*;

public interface IBase {
   
	// Métodos para obter listas de laboratórios, departamentos, professores, disciplinas e alunos
    List<Laboratorio> getLaboratorios();
    List<Departamento> getDepartamentos();
    List<Professor> getProfessores();
    List<Disciplina> getDisciplinas();
    List<Aluno> getAlunos(int qtde, int inicio);
    void BasePrint();
}