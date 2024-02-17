import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Agendamento {
    private String cliente;

    public Agendamento(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}

class Barbearia {
    private String[] barbeiros;
    private List<List<List<Agendamento>>> agendamentos;

    public Barbearia(String[] barbeiros, List<List<List<Agendamento>>> agendamentos) {
        this.barbeiros = barbeiros;
        this.agendamentos = agendamentos;
    }

    public void agendar(int diaIndex, int barbeiroIndex, int horarioIndex, String cliente) {
        if (agendamentos.get(diaIndex).get(barbeiroIndex).get(horarioIndex) == null) {
            agendamentos.get(diaIndex).get(barbeiroIndex).set(horarioIndex, new Agendamento(cliente));
            System.out.println("Agendamento realizado para " + diaIndex + " - " + horarioIndex + " com " + barbeiros[barbeiroIndex]);
        } else {
            System.out.println("Desculpe, o horário " + diaIndex + " - " + horarioIndex + " com " + barbeiros[barbeiroIndex] + " já está ocupado.");
        }
    }

    public void consultarAgendamento(int diaIndex, int barbeiroIndex, int horarioIndex, List<String> dias, List<String> horarios) {
        Agendamento agendamento = agendamentos.get(diaIndex).get(barbeiroIndex).get(horarioIndex);
        if (agendamento != null) {
            System.out.println("Horário agendado para " + dias.get(diaIndex) + " - " + horarios.get(horarioIndex) + " com " + barbeiros[barbeiroIndex] + " para o cliente " + agendamento.getCliente());
        } else {
            System.out.println("Horário disponível para agendamento em " + dias.get(diaIndex) + " - " + horarios.get(horarioIndex) + " com " + barbeiros[barbeiroIndex]);
        }
    }
}

public class Principal {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();
        int ano = dataAtual.getYear();
        int mes = dataAtual.getMonthValue();

        LocalDate primeiroDiaDoMes = LocalDate.of(ano, mes, 1);
        LocalDate ultimoDiaDoMes = primeiroDiaDoMes.plusMonths(1).minusDays(1);

        List<String> diasDoMes = gerarListaDeDatas(primeiroDiaDoMes, ultimoDiaDoMes);

        String[] barbeiros = {"Barbeiro1", "Barbeiro2", "Barbeiro3"};

        List<List<List<Agendamento>>> agendamentos = new ArrayList<>();
        for (int i = 0; i < diasDoMes.size(); i++) {
            List<List<Agendamento>> listaBarbeiros = new ArrayList<>();
            for (int j = 0; j < barbeiros.length; j++) {
                listaBarbeiros.add(new ArrayList<>());
            }
            agendamentos.add(listaBarbeiros);
        }

        Barbearia barbearia = new Barbearia(barbeiros, agendamentos);

        Scanner scanner = new Scanner(System.in);

        barbearia.agendar(0, 1, 2, "Cliente1");

        barbearia.consultarAgendamento(0, 1, 2, diasDoMes, gerarListaDeHorarios());
    }

    public static List<String> gerarListaDeDatas(LocalDate primeiroDia, LocalDate ultimoDia) {
        List<String> listaDeDatas = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (LocalDate data = primeiroDia; !data.isAfter(ultimoDia); data = data.plusDays(1)) {
            listaDeDatas.add(data.format(formatter));
        }

        return listaDeDatas;
    }

    public static List<String> gerarListaDeHorarios() {
        List<String> listaDeHorarios = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            int hora = 7 + i / 2;
            int minuto = (i % 2) * 30;
            listaDeHorarios.add(String.format("%02d:%02d", hora, minuto));
        }
        return listaDeHorarios;
    }
}
