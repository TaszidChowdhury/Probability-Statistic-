function y_noisy = salter(x, y, noise_level, file_name)
    % Add random noise to the function values
    noise = noise_level * (rand(size(y)) - 0.5); % Generate random noise
    y_noisy = y + noise; % Add noise to the function values

    % Save data to CSV
    data = [x(:), y_noisy(:)]; % Combine x and noisy y into a single matrix
    csvwrite(file_name, data); % Write to CSV file
end

