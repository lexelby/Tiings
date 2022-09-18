package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_155
   extends TilingType
{
   public TilingTypeNC5_155(){
      super( "NC5-155", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 0,1, 2,0,1, 0},
            
            {0, 3,4, 0,4,0, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "d=e=2a\nA=90\n2B+C=180\nC+D=360\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 2.0;
      double h1 = getParam(paramValues,0)/100 / (1 + Math.sqrt(3));
      double w1 = 1 - h1;
      double a = Math.sqrt(w1*w1+h1*h1);
      double h2 = a/2-h1;
      double w2 = w1*h2/h1;
      double f = lnt / (h1+h2+ 3*w1+w2);
      h1 *= f;
      h2 *= f;
      w1 *= f;
      w2 *= f;
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, 3*w1+w2, 0);
      baseTile.setPoint(2, 2*w1, h1+h2);
      baseTile.setPoint(3, w1, h2);
      baseTile.setPoint(4, 0, h1+h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(2);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(2);
      offsets[2] = tiles[6].getX(4)-tiles[3].getX(4);
      offsets[3] = tiles[6].getY(4)-tiles[3].getY(4);
   }
}
