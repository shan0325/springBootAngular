import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Hero } from './hero';
import { HEROES } from './mock-heroes';

@Injectable()
export class HeroService {

    private headers: Headers = new Headers({'Content-Type': 'application/json'});
    private heroesUrl: string = '/app/heroes';

    constructor(private http: Http) {}

    getHeroes(): Promise<Hero[]> {
        //return Promise.resolve(HEROES);
        return this.http.get(this.heroesUrl)
                    .toPromise()
                    .then(response => response.json().data as Hero[])
                    .catch(this.handleError);
    }

    getHeroesSlowly(): Promise<Hero[]> {
        return new Promise(resolve => {
            // Simulate server latency with 2 second delay
            setTimeout(() => resolve(this.getHeroes()), 2000);
        });
    }

    getHero(id: number): Promise<Hero> {
        return this.getHeroes()
                   .then(heroes => heroes.find(hero => hero.id === id));
    }

    update(hero: Hero): Promise<Hero> {
        const update_url = this.heroesUrl + '/' + hero.id;
        return this.http
                    .put(update_url, JSON.stringify(hero), {headers: this.headers})
                    .toPromise()
                    .then(() => hero)
                    .catch(this.handleError);
    }

    handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}