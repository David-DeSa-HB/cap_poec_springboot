<%@ page contentType="text/html;charset=UTF-8" %>

<a class="col-md-4 mt-2 main-game-card" href="${UrlRoute.URL_GAMES}/${game.slug}">
    <div class="game-card">
        <div class="game-card-img">
            <img alt="${game.name}" src="${game.image}">
        </div>
        <div class="d-flex justify-content-between">
            <p>${game.name}</p>
            <p>${game.publisher.name}</p>
        </div>
    </div>
</a>