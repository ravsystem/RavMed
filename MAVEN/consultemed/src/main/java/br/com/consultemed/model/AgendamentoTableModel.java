package br.com.consultemed.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AgendamentoTableModel extends AbstractTableModel{

	private List<Agendamento> linhasAgendamentos;
	private String[] colunas;
	
	public AgendamentoTableModel(List<Agendamento> agendamentos) {
		
		this.linhasAgendamentos = new ArrayList<Agendamento>(agendamentos);
	}
	
	public int getRowCount() {
		 //Quantidade de linhas da tabela, aqui as linhas v�o ser do tamanho da lista(List).
        return linhasAgendamentos.size();
    }
	
    public int getColumnCount() {
    	//Quantidade de Colunas da tabela, no caso aqui s�o 4.
        return 5;
    }
    
    public String getColumnName(int columnIndex) {
    	 //Nome das colunas da JTable
        String colunas[] = {"Codigo", "Paciente", "Medico", "Data","hora"};
        return colunas[columnIndex];
    }
    
    public Object getValueAt(int row, int column) {
    	//Retornar o valor da coluna column e da linha row da JTable.
    	Agendamento agend = linhasAgendamentos.get(row);
        if (column == 0) return agend.getId();
        else if (column == 1) return agend.getPaciente();
        else if (column == 2) return agend.getMedico();
        else if (column == 3) return agend.getData();
        else return agend.getHora();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o registro referente a linha especificada.
    	Agendamento agend = linhasAgendamentos.get(rowIndex);
     
    	if (columnIndex == 0) agend.setId((Long)aValue);
        else if (columnIndex == 1) agend.setPaciente((String)aValue);
        else if (columnIndex == 2) agend.setMedico((String)aValue);
        else if (columnIndex == 2) agend.setData((String)aValue);
        else if (columnIndex == 2) agend.setHora((String)aValue);
        else throw new IndexOutOfBoundsException("columnIndex out of bounds");
        	
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
    }

 // Retorna o s�cio referente a linha especificada
    public Agendamento getAgendamento(int indiceLinha) {
        return linhasAgendamentos.get(indiceLinha);
    }
     
    // Adiciona o s�cio especificado ao modelo
    public void addAgendamento(Agendamento agendamento) {
        // Adiciona o registro.
    	linhasAgendamentos.add(agendamento);
     
        // Pega a quantidade de registros e subtrai 1 para
        // achar o �ltimo �ndice. A subtra��o � necess�ria
        // porque os �ndices come�am em zero.
        int ultimoIndice = getRowCount() - 1;
     
        // Notifica a mudan�a.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
     
    // Remove o s�cio da linha especificada.
    public void removeAgendamento(int indiceLinha) {
        // Remove o registro.
    	linhasAgendamentos.remove(indiceLinha);
     
        // Notifica a mudan�a.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
     
    // Adiciona uma lista de s�cios no final da lista.
    public void addListaDeAgendamentos(List<Agendamento> agendamentos) {
        // Pega o tamanho antigo da tabela, que servir�
        // como �ndice para o primeiro dos novos registros
        int indice = getRowCount();
     
        // Adiciona os registros.
        linhasAgendamentos.addAll(agendamentos);
     
        // Notifica a mudan�a.
        fireTableRowsInserted(indice, indice + agendamentos.size());
    }
     
    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de s�cios.
    	linhasAgendamentos.clear();
     
        // Notifica a mudan�a.
        fireTableDataChanged();
    }
}
