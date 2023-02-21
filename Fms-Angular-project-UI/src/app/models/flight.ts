export interface Flight {
    id: number;
    flightCode: string;
    available: boolean;
    airlineName: string;
    price: number;
    source: string;
    destination: string;
    freeMeal: boolean;
    numberOfStops: number;
    seatsAvailable: number;
}