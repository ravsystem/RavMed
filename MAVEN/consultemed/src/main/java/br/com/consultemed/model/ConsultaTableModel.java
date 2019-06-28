package br.com.consultemed.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ConsultaTableModel extends AbstractTableModel{
	
	private List<Consulta> linhasConsultas;
	private String[] colunas;
	
	public ConsultaTableModel(List<Consulta> consultas) {
		
		this.linhasConsultas = new ArrayList<Consulta>(consultas);
	}
	
	public int getRowCount() {
		 //Quantidade de linhas da tabela, aqui as linhas v�o ser do tamanho da lista(List).
        return linhasConsultas.size();
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
    	Consulta consult = linhasConsultas.get(row);
        if (column == 0) return consult.getId();
        else if (column == 1) return consult.getPaciente();
        else if (column == 2) return consult.getMedico();
        else if (column == 3) return consult.getData();
        else return consult.getHora();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o registro referente a linha especificada.
    	Consulta consult = linhasConsultas.get(rowIndex);
     
    	if (columnIndex == 0) consult.setId((Long)aValue);
        else if (columnIndex == 1) consult.setPaciente((String)aValue);
        else if (columnIndex == 2) consult.setMedico((String)aValue);
        else if (columnIndex == 2) consult.setData((String)aValue);
        else if (columnIndex == 2) consult.setHora((String)aValue);
        else throw new IndexOutOfBoundsException("columnIndex out of bounds");
        	
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
    }

 // Retorna o s�cio referente a linha especificada
    public Consulta getConsulta(int indiceLinha) {
        return linhasConsultas.get(indiceLinha);
    }
     
    // Adiciona o s�cio especificado ao modelo
    public void addConsulta(Consulta consulta) {
        // Adiciona o registro.
    	linhasConsultas.add(consulta);
     
        // Pega a quantidade de registros e subtrai 1 para
        // achar o �ltimo �ndice. A subtra��o � necess�ria
        // porque os �ndices come�am em zero.
        int ultimoIndice = getRowCount() - 1;
     
        // Notifica a mudan�a.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
     
    // Remove o s�cio da linha especificada.
    public void removeConsulta(int indiceLinha) {
        // Remove o registro.
    	linhasConsultas.remove(indiceLinha);
     
        // Notifica a mudan�a.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
     
    // Adiciona uma lista de s�cios no final da lista.
    public void addListaDeConsultas(List<Consulta> consultas) {
        // Pega o tamanho antigo da tabela, que servir�
        // como �ndice para o primeiro dos novos registros
        int indice = getRowCount();
     
        // Adiciona os registros.
        linhasConsultas.addAll(consultas);
     
        // Notifica a mudan�a.
        fireTableRowsInserted(indice, indice + consultas.size());
    }
     
    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de s�cios.
    	linhasConsultas.clear();
     
        // Notifica a mudan�a.
        fireTableDataChanged();
    }

}
