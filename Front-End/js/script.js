
document.addEventListener('DOMContentLoaded', () => {
    
    // 1. Funcionalidade para Destaque de Itens de Problema
    
    // Seleciona todos os containers de itens de problema
    const problemItems = document.querySelectorAll('.problem-item');

    problemItems.forEach(item => {
        // Encontra o checkbox dentro de cada item
        const checkbox = item.querySelector('input[type="checkbox"]');

        // Função para alternar a classe de destaque
        const toggleSelection = () => {
            if (checkbox.checked) {
                // Adiciona a classe 'selected' para o destaque visual definido no CSS
                item.classList.add('selected');
                console.log(`Problema selecionado: ${item.getAttribute('data-problema')}`);
            } else {
                // Remove a classe se estiver desmarcado
                item.classList.remove('selected');
            }
        };

        // Adiciona um listener para quando o estado do checkbox mudar (clicando no checkbox)
        checkbox.addEventListener('change', toggleSelection);

        // Adiciona um listener no container para permitir que o clique em qualquer parte selecione
        item.addEventListener('click', (event) => {
            // Verifica se o clique não foi diretamente no checkbox (para evitar alternar duas vezes)
            if (event.target !== checkbox) {
                checkbox.checked = !checkbox.checked;
                // Dispara o evento 'change' manualmente para aplicar o CSS
                checkbox.dispatchEvent(new Event('change'));
            }
        });
    });

    
    // 2. Implementação de Scroll Suave para a Navbar
    
    // Seleciona todos os links na navbar que iniciam com '#' (links internos)
    document.querySelectorAll('.navbar a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault(); // Impede o comportamento de clique padrão (pulo brusco)

            const targetId = this.getAttribute('href');
            // Remove o '#' para obter o ID do elemento alvo
            const targetElement = document.querySelector(targetId);
            
            // Verifica se o elemento alvo realmente existe na página
            if (targetElement) {
                
                // Define um offset (espaço) para compensar a navbar fixa
                // Ajuste o valor '70'px se sua navbar tiver altura diferente
                const offset = 70; 
                
                // Rola suavemente até o elemento alvo
                window.scrollTo({
                    // Calcula a posição do topo do elemento menos o offset da navbar
                    top: targetElement.offsetTop - offset,
                    behavior: 'smooth' // Habilita o scroll suave
                });
            } else {
                console.error(`Elemento com ID ${targetId} não encontrado.`);
            }
        });
    });

});