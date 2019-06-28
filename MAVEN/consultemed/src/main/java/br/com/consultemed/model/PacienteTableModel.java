package br.com.consultemed.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PacienteTableModel extends AbstractTableModel{
	
	private List<Paciente> linhasPacientes;
	private String[] colunas;
	
	public PacienteTableModel(List<Paciente> pacientes) {
		
		this.linhasPacientes = new ArrayList<Paciente>(pacientes);
	}
	
	public int getRowCount() {
		 //Quantidade de linhas da tabela, aqui as linhas v�o ser do tamanho da lista(List).
        return linhasPacientes.size();
    }
	
    public int getColumnCount() {
    	//Quantidade de Colunas da tabela, no caso aqui s�o 4.
        return 4;
    }
    
    public String getColumnName(int columnIndex) {
    	 //Nome das colunas da JTable
        String colunas[] = {"Codigo", "Nome", "idade", "Telefone"};
        return colunas[columnIndex];
    }
    
    public Object getValueAt(int row, int column) {
    	//Retornar o valor da coluna column e da linha row da JTable.
    	Paciente paciente = linhasPacientes.get(row);
        if (column == 0) return paciente.getId();
        else if (column == 1) return paciente.getNome();
        else if (column == 2) return paciente.getIdade();
        else return paciente.getTelefone();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o registro referente a linha especificada.
    	Paciente paciente = linhasPacientes.get(rowIndex);
     
    	if (columnIndex == 0) paciente.setId((Long)aValue);
        else if (columnIndex == 1) paciente.setNome((String)aValue);
        else if (columnIndex == 2) paciente.setIdade((String)aValue);
        else if (columnIndex == 2) paciente.setTelefone((String)aValue);
        else throw new IndexOutOfBoundsException("columnIndex out of bounds");
        	
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
    }

 // Retorna o s�cio referente a linha especificada
    public Paciente getPaciente(int indiceLinha) {
        return linhasPacientes.get(indiceLinha);
    }
     
    // Adiciona o s�cio especificado ao modelo
    public void addPaciente(Paciente paciente) {
        // Adiciona o registro.
    	linhasPacientes.add(paciente);
     
        // Pega a quantidade de registros e subtrai 1 para
        // achar o �ltimo �ndice. A subtra��o � necess�ria
        // porque os �ndices come�am em zero.
        int ultimoIndice = getRowCount() - 1;
     
        // Notifica a mudan�a.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
     
    // Remove o s�cio da linha especificada.
    public void removePaciente(int indiceLinha) {
        // Remove o registro.
    	linhasPacientes.remove(indiceLinha);
     
        // Notifica a mudan�a.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
     
    // Adiciona uma lista de s�cios no final da lista.
    public void addListaDePacientes(List<Paciente> pacientes) {
        // Pega o tamanho antigo da tabela, que servir�
        // como �ndice para o primeiro dos novos registros
        int indice = getRowCount();
     
        // Adiciona os registros.
        linhasPacientes.addAll(pacientes);
     
        // Notifica a mudan�a.
        fireTableRowsInserted(indice, indice + pacientes.size());
    }
     
    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de s�cios.
    	linhasPacientes.clear();
     
        // Notifica a mudan�a.
        fireTableDataChanged();
    }

}
