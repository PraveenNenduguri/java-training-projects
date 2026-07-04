package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import exception.MovieNotFoundException;
import model.Movie;

public class MovieService {

    Scanner sc = new Scanner(System.in);

    private ArrayList<Movie> movies = new ArrayList<>();

    // Add Movie
    public void addMovie() {

        System.out.print("Enter Movie ID : ");
        int movieId = sc.nextInt();
        sc.nextLine();

        // Check Duplicate Movie ID
        for (Movie movie : movies) {

            if (movie.getMovieId() == movieId) {

                System.out.println("Movie ID already exists.");
                return;
            }
        }

        System.out.print("Enter Movie Name : ");
        String movieName = sc.nextLine();

        System.out.print("Enter Language : ");
        String language = sc.nextLine();

        System.out.print("Enter Genre : ");
        String genre = sc.nextLine();

        System.out.print("Enter Duration : ");
        String duration = sc.nextLine();

        System.out.print("Enter Theatre : ");
        String theatre = sc.nextLine();

        System.out.print("Enter Show Time : ");
        String showTime = sc.nextLine();

        System.out.print("Enter Ticket Price : ");
        double ticketPrice = sc.nextDouble();

        Movie movie = new Movie(
                movieId,
                movieName,
                language,
                genre,
                duration,
                theatre,
                showTime,
                ticketPrice);

        movies.add(movie);

        System.out.println("\nMovie Added Successfully.");
    }

    // Update Movie
    public void updateMovie() {

        try {

            System.out.print("Enter Movie ID to Update : ");
            int movieId = sc.nextInt();
            sc.nextLine();

            Movie movie = getMovieById(movieId);

            if (movie == null) {
                throw new MovieNotFoundException("Movie Not Found.");
            }

            System.out.print("Enter New Movie Name : ");
            movie.setMovieName(sc.nextLine());

            System.out.print("Enter Language : ");
            movie.setLanguage(sc.nextLine());

            System.out.print("Enter Genre : ");
            movie.setGenre(sc.nextLine());

            System.out.print("Enter Duration : ");
            movie.setDuration(sc.nextLine());

            System.out.print("Enter Theatre : ");
            movie.setTheatre(sc.nextLine());

            System.out.print("Enter Show Time : ");
            movie.setShowTime(sc.nextLine());

            System.out.print("Enter Ticket Price : ");
            movie.setTicketPrice(sc.nextDouble());

            System.out.println("Movie Updated Successfully.");

        } catch (MovieNotFoundException e) {

            System.out.println(e.getMessage());

        }
    }

    // Delete Movie
    public void deleteMovie() {

        try {

            System.out.print("Enter Movie ID : ");
            int movieId = sc.nextInt();

            Iterator<Movie> iterator = movies.iterator();

            while (iterator.hasNext()) {

                Movie movie = iterator.next();

                if (movie.getMovieId() == movieId) {

                    iterator.remove();

                    System.out.println("Movie Deleted Successfully.");
                    return;
                }
            }

            throw new MovieNotFoundException("Movie Not Found.");

        } catch (MovieNotFoundException e) {

            System.out.println(e.getMessage());

        }
    }

    // Search Movie
    public void searchMovie() {

        try {

            System.out.print("Enter Movie ID : ");
            int movieId = sc.nextInt();

            Movie movie = getMovieById(movieId);

            if (movie == null) {

                throw new MovieNotFoundException("Movie Not Found.");
            }

            movie.displayMovie();

        } catch (MovieNotFoundException e) {

            System.out.println(e.getMessage());

        }
    }

    // View All Movies
    public void viewMovies() {

        if (movies.isEmpty()) {

            System.out.println("No Movies Available.");
            return;
        }

        System.out.println("\n========== MOVIE LIST ==========");

        for (Movie movie : movies) {

            movie.displayMovie();
        }
    }

    // Get Movie By ID
    public Movie getMovieById(int movieId) {

        for (Movie movie : movies) {

            if (movie.getMovieId() == movieId) {

                return movie;
            }
        }

        return null;
    }

    // Getter
    public ArrayList<Movie> getMovies() {

        return movies;
    }

}