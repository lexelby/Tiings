package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_57
   extends TilingType
{
   public TilingTypeNC6_57(){
      super( "NC6-57", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 50, 60, 10};
      paramName = new String[]{"Aspect", "Indentation", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,1,2, 1},
            {1, 5,2, 1,2,5, 1},
            {0, 1,2, 2,0,1, 0},

            {0, 4,0, 0,2,4, 1},
            {1, 0,1, 4,1,2, 0},
            {1, 5,2, 5,2,5, 0},
            {0, 1,2, 6,0,1, 1},
      };
      info = "a=e\nb=c\nd=f\nC=D\nD+E=360\n(A+B+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = (lntotal - w)/2;

      double ind = w * ( getParam(paramValues, 1)/100 *1.5 - 0.5 );
      double h1 = h * getParam(paramValues, 2)/100;
      double h2 = h - h1;
      
      double minind = w*h1/(h1-2*h);
      if( ind<minind) ind = minind;
      
      baseTile.setPoint(0,     ind, -h);
      baseTile.setPoint(1,       w,  0);
      baseTile.setPoint(2,     ind,  h);
      baseTile.setPoint(3,     ind, h1);
      baseTile.setPoint(4,    -ind,  0);
      baseTile.setPoint(5,    -ind,-h2);
      // ind,-h, to w,0;  want -ind,-h2 to be to the left of it
      // slope line: w-ind / h
      // slope base to point: -2ind/ h1
      // border is  (w-ind) / h == -2ind/h1
      // w-ind  == ind * -2h/h1
      // w  == ind * (h1-2h)/h1
      // ind == w*h1/(h1-2h)
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(5);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(5);
   }
}