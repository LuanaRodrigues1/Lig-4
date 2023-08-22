package ranking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ArquivoCsv {
	private static final String ARQUIVO = "pontuacao.csv";
	
    public static void adicionarDados(String nome, int pontos) {
    	try {
    		BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true));
			
            writer.write(nome + "," + pontos);
            writer.newLine();
            writer.close();
            
            System.out.println("Os dados " + nome + ", " + pontos + "foram adicionados com sucesso");
		} catch (IOException e) {
			System.err.println("Erro ao preencher dados no arquivo "+ ARQUIVO + ":" + e.getMessage());
		}
    }

    public static void limparArquivo(){
        File arquivo = new File(ARQUIVO);

        try {
            boolean arquivoDeletado = arquivo.delete();
            
            if (arquivoDeletado) {
                boolean arquivoCriado = arquivo.createNewFile();
                if (arquivoCriado) {
                    System.out.println("O novo arquivo " + ARQUIVO + "foi criado");
                } else {
                    System.err.println("Erro ao criar novo arquivo.");
                }
            } else {
                System.err.println("Erro ao excluir o arquivo.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao limpar o arquivo " + ARQUIVO + ": " + e.getMessage());
        }
    }
    
    public static JTable criarTabela() throws FileNotFoundException, IOException {
        Map<String, Integer> pontosPorNome = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] data = linha.split(",");
                String nome = data[0];
                int pontos = Integer.parseInt(data[1]);
                
                pontosPorNome.put(nome, pontosPorNome.getOrDefault(nome, 0) + pontos);
            }
        }
      
        DefaultTableModel modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Pontos");
        
        for (Map.Entry<String, Integer> entry : pontosPorNome.entrySet()) {
            String nome = entry.getKey();
            int pontos = entry.getValue();
            
            modeloTabela.addRow(new Object[] { nome, pontos });
        }
        
        JTable tabela = new JTable(modeloTabela);
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(modeloTabela);
        tabela.setRowSorter(sorter);
        
        sorter.setSortable(1, false); 
        
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        
        return tabela;
    }
    
}
