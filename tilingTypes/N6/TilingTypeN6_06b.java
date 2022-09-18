package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_06b
   extends TilingType
{
   public TilingTypeN6_06b(){
      super( "N6-6b", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 50, 30, 45, 60};
      paramName = new String[]{ "Aspect", "Relative Length 1", "Relative Length 2", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {2, 5,0, 0,2,3, 1},

            {0, 5,4, 0,4,5, 0},
            {1, 4,3, 3,3,4, 0},
            {2, 5,0, 3,2,3, 1},
      };
      info = "a=d\nb=f\nA=F\nA+B+C=360\n(D+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.2 * paramValues[0]/100.;
      double w = 1.2 - h;
      double ln = h *2 * getParam(paramValues,1)/100.;
      h = h*2-ln;
      double w1 = w *  paramValues[2]/100.;
      double os = Math.tan( (getParam(paramValues,3)/50.-1)*Math.PI/2 );

      baseTile.setPoint(0,  0, -ln/2);
      baseTile.setPoint(1, w1, -h/2 );
      baseTile.setPoint(2,  w, os-ln/2);
      baseTile.setPoint(3,  w, os+ln/2);
      baseTile.setPoint(4, w1,  h/2 );
      baseTile.setPoint(5,  0,  ln/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[5].getX(2);
      offsets[3] = tiles[2].getY(1)-tiles[5].getY(2);
   }
}