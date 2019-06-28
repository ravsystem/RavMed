package br.com.consultemed.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class OperadorTableModel extends AbstractTableModel{
	
	private List<Operador> linhasOperadores;
	private String[] colunas;
	
	public OperadorTableModel(List<Operador> operadores) {
		
		this.linhasOperadores = new ArrayList<Operador>(operadores);
	}
	
	public int getRowCount() {
		 //Quantidade de linhas da tabela, aqui as linhas v�o ser do tamanho da lista(List).
        return linhasOperadores.size();
    }
	
    public int getColumnCount() {
    	//Quantidade de Colunas da tabela, no caso aqui s�o 4.
        return 2;
    }
    
    public String getColumnName(int columnIndex) {
    	 //Nome das colunas da JTable
        String colunas[] = {"Codigo", "Nome"};
        return colunas[columnIndex];
    }
    
    public Object getValueAt(int row, int column) {
    	//Retornar o valor da coluna column e da linha row da JTable.
    	Operador oper = linhasOperadores.get(row);
        if (column == 0) return oper.getId();
        else return oper.getNome();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o registro referente a linha especificada.
    	Operador agend = linhasOperadores.get(rowIndex);
     
    	if (columnIndex == 0) agend.setId((Long)aValue);
        else if (columnIndex == 1) agend.setNome((String)aValue);
        else throw new IndexOutOfBoundsException("columnIndex out of bounds");
        	
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
    }

 // Retorna o s�cio referente a linha especificada
    public Operador getOperador(int indiceLinha) {
        return linhasOperadores.get(indiceLinha);
    }
     
    // Adiciona o s�cio especificado ao modelo
    public void addOperador(Operador operador) {
        // Adiciona o registro.
    	linhasOperadores.add(operador);
     
        // Pega a quantidade de registros e subtrai 1 para
        // achar o �ltimo �ndice. A subtra��o � necess�ria
        // porque os �ndices come�am em zero.
        int ultimoIndice = getRowCount() - 1;
     
        // Notifica a mudan�a.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
     
    // Remove o s�cio da linha especificada.
    public void removeOperador(int indiceLinha) {
        // Remove o registro.
    	linhasOperadores.remove(indiceLinha);
     
        // Notifica a mudan�a.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
     
    // Adiciona uma lista de s�cios no final da lista.
    public void addListaDeOperadores(List<Operador> operadores) {
        // Pega o tamanho antigo da tabela, que servir�
        // como �ndice para o primeiro dos novos registros
        int indice = getRowCount();
     
        // Adiciona os registros.
        linhasOperadores.addAll(operadores);
     
        // Notifica a mudan�a.
        fireTableRowsInserted(indice, indice + operadores.size());
    }
     
    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de s�cios.
    	linhasOperadores.clear();
     
        // Notifica a mudan�a.
        fireTableDataChanged();
    }

}
