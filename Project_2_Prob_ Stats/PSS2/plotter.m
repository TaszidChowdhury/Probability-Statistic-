function plotter(x, y, title_str, file_name)
    % Plot the function
    plot(x, y, 'b-', 'LineWidth', 2);
    title(title_str);
    xlabel('x');
    ylabel('f(x)');
    grid on;

    % Save data to CSV
    data = [x(:), y(:)]; % Combine x and y into a single matrix
    csvwrite(file_name, data); % Write to CSV file
end

