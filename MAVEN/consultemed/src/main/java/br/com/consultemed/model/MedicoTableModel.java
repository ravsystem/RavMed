package br.com.consultemed.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MedicoTableModel extends AbstractTableModel{
	
	private List<Medico> linhasMedicos;
	private String[] colunas;
	
	public MedicoTableModel(List<Medico> medicos) {
		
		this.linhasMedicos = new ArrayList<Medico>(medicos);
	}
	
	public int getRowCount() {
		 //Quantidade de linhas da tabela, aqui as linhas vão ser do tamanho da lista(List).
        return linhasMedicos.size();
    }
	
    public int getColumnCount() {
    	//Quantidade de Colunas da tabela, no caso aqui são 4.
        return 3;
    }
    
    public String getColumnName(int columnIndex) {
    	 //Nome das colunas da JTable
        String colunas[] = {"Codigo", "Nome", "Especialidade"};
        return colunas[columnIndex];
    }
    
    public Object getValueAt(int row, int column) {
    	//Retornar o valor da coluna column e da linha row da JTable.
    	Medico medico = linhasMedicos.get(row);
        if (column == 0) return medico.getId();
        else if (column == 1) return medico.getNome();
        else return medico.getEspecialidade();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o registro referente a linha especificada.
    	Medico medico = linhasMedicos.get(rowIndex);
     
    	if (columnIndex == 0) medico.setId((Long)aValue);
        else if (columnIndex == 1) medico.setNome((String)aValue);
        else if (columnIndex == 2) medico.setEspecialidade((String)aValue);
        else throw new IndexOutOfBoundsException("columnIndex out of bounds");
        	
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }

 // Retorna o sócio referente a linha especificada
    public Medico getMedico(int indiceLinha) {
        return linhasMedicos.get(indiceLinha);
    }
     
    // Adiciona o sócio especificado ao modelo
    public void addMedico(Medico agendamento) {
        // Adiciona o registro.
    	linhasMedicos.add(agendamento);
     
        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;
     
        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
     
    // Remove o sócio da linha especificada.
    public void removeMedico(int indiceLinha) {
        // Remove o registro.
    	linhasMedicos.remove(indiceLinha);
     
        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
     
    // Adiciona uma lista de sócios no final da lista.
    public void addListaDeAgendamentos(List<Medico> agendamentos) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();
     
        // Adiciona os registros.
        linhasMedicos.addAll(agendamentos);
     
        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + agendamentos.size());
    }
     
    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
    	linhasMedicos.clear();
     
        // Notifica a mudança.
        fireTableDataChanged();
    }

}
